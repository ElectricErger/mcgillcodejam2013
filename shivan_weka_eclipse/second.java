import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import weka.core.converters.*;
import weka.classifiers.Classifier;
import weka.classifiers.misc.SerializedClassifier;
import weka.core.Instances;
import weka.core.DenseInstance;
import weka.core.SerializationHelper;



public class second {

	public static void main(String[] args) throws Exception, IOException {
		// load unlabeled data
//		DataSource source = new DataSource("C:/Code Jam 2013/sample_input.csv");
//		System.out.println(source.getStructure().toSummaryString());
//		System.out.println("1");
//		Instances data = source.getDataSet();
//		System.out.println("this is the DATA");
//		System.out.println(data);
		
		// setting the options for the data
		CSVLoader loader = new CSVLoader();
		loader.setSource(new File("C:/Code Jam 2013/sample_input.csv"));
		loader.setDateAttributes("1");
		loader.setDateFormat("yyyy-MM-dd'T'HH:mm-ss':00'");
		loader.setMissingValue("null");
		
		
//		System.out.println("FORMAT: "+ data.attribute(0).getDateFormat().toString());
//		System.out.println("result"+data.attribute("Date"));
//		System.out.println(loader.getStructure().toSummaryString());
//		System.out.println("loader: "+loader.getDataSet());

		Instances unlabeled = loader.getDataSet();
		if (loader.getDataSet().classIndex() == -1) {
			unlabeled.setClassIndex(unlabeled.numAttributes() - 1);
		}
		//		}
		//		unlabeled.setClassIndex(unlabeled.numAttributes() - 1);
		Instances labeled = new Instances(unlabeled);
//		System.out.println


		//		DataSource 
		//		
		//		
		//		Instances unlabeled;
		//		unlabeled = new Instances(new BufferedReader(new FileReader("C:/Code Jam 2013/sample_input.csv")));
		//
		//
		//		// set class attribute
		//		unlabeled.setClassIndex(unlabeled.numAttributes() - 1);
		//
		//		// create copy
		//		Instances labeled = new Instances(unlabeled);

		// get the classifier
		SerializedClassifier my_classifier = new SerializedClassifier();
		my_classifier.setModelFile(new File("C:/Code Jam 2013/test3.model"));

		// Vector v = (Vector) SerializationHelper.read("/c/Code Jam 2013/test3.model");
		// Classifier cl = (Classifier) v.get(0);
		// Instances header = (Instances) v.get(1);

		//Classifier cls = (Classifier) weka.core.SerializationHelper.read("/some/where/nBayes.model");

		// label instances
		for (int i = 0; i < unlabeled.numInstances(); i++) {
			double clsLabel = my_classifier.classifyInstance(unlabeled.instance(i));
			labeled.instance(i).setClassValue(clsLabel);
		}
		// save labeled data
		BufferedWriter writer = new BufferedWriter(
				new FileWriter("C:/Code Jam 2013/my_output3.csv"));
		writer.write(labeled.toString());
		writer.newLine();
		writer.flush();
		writer.close();
	}
}