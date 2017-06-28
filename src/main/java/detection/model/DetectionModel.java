package detection.model;


import data.Example;
import feature.Feature;
import libsvm.*;
import org.jsoup.select.Elements;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Petar on 07.07.2016.
 */

public abstract class DetectionModel {

    svm_model model;
    List<Example> examples;

    public DetectionModel() {
    }

    public abstract void setExamples(Elements elements);


    public void train(List<Example> examples){

        // Preparing the SVM param
        svm_parameter param=new svm_parameter();
        param.svm_type=svm_parameter.C_SVC;
        param.kernel_type=svm_parameter.RBF;
        param.gamma=0.5;
        param.nu=0.5;
        param.cache_size=20000;
        param.C=1;
        param.eps=0.001;
        param.p=0.1;


        //prepare data
        HashMap<Integer, HashMap<Integer, Double>> featuresTraining=new HashMap<Integer, HashMap<Integer, Double>>();
        HashMap<Integer, Integer> labelTraining=new HashMap<Integer, Integer>();

        HashSet<Integer> features=new HashSet<Integer>();

        for(Example example : examples){
            featuresTraining.put(example.getId(), new HashMap<Integer, Double>());
            labelTraining.put(example.getId(), example.getLabel());
            for(Feature feature : example.getFeatures()){
                features.add(feature.getId());
                featuresTraining.get(example.getId()).put(feature.getId(), feature.getValue());
            }
        }

        //train model

        svm_problem prob=new svm_problem();
        int numTrainingInstances=featuresTraining.keySet().size();
        prob.l=numTrainingInstances;
        prob.y=new double[prob.l];
        prob.x=new svm_node[prob.l][];

        for(int i=0;i<numTrainingInstances;i++) {
            prob.x[i] = new svm_node[featuresTraining.get(i).keySet().size()];
            int indx=0;
            for(Integer id:featuresTraining.get(i).keySet()){
                svm_node node=new svm_node();
                node.index=id;
                node.value=featuresTraining.get(i).get(id);
                prob.x[i][indx]=node;
                indx++;
            }
            prob.y[i]=labelTraining.get(i);
        }

        this.model=svm.svm_train(prob,param);
    }

    public void test(List<Example> examples){
        //prepare data
        HashMap<Integer, HashMap<Integer, Double>> featuresTesting=new HashMap<Integer, HashMap<Integer, Double>>();

        for(Example example : examples){
            featuresTesting.put(example.getId(), new HashMap<Integer, Double>());
            for(Feature feature : example.getFeatures()){
                featuresTesting.get(example.getId()).put(feature.getId(), feature.getValue());
            }
        }

        for(Integer testInstance:featuresTesting.keySet()){
            int numFeatures = featuresTesting.get(testInstance).keySet().size();
            svm_node[] x = new svm_node[numFeatures];
            int featureIndx = 0;
            for(Integer feature : featuresTesting.get(testInstance).keySet()){
                x[featureIndx] = new svm_node();
                x[featureIndx].index = feature;
                x[featureIndx].value = featuresTesting.get(testInstance).get(feature);
                featureIndx++;
            }

            double d=svm.svm_predict(this.model, x);

            System.out.println(testInstance+"\t"+d);
        }
    }
}
