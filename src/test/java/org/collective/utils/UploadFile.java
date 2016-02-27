/*
package org.collective.utils;

import java.io.File;
import java.io.IOException;


import org.collective.maincontroller.MainController;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.Upload;



	public class UploadFile {
		private static String bucketName = "the-collective"; 
		private static String key        = "AKIAJJCNZCV4NGXCJGDA";      
		
		public static void uploadFile() throws IOException, InterruptedException
		{
			
			
			for(int i=0;i<MainController.Videos.size();i++)
			{
				  
				//ProfileCredentialsProvider a = new ProfileCredentialsProvider();
				
					AmazonS3Client s3Client = new AmazonS3Client(new BasicAWSCredentials(key, "FQyAEJKA4vWWqWnWWjuRnupYQXEoLqL"));
			        TransferManager tm = new TransferManager(s3Client);        
			        //TransferManager tm = new TransferManager();
			       
			        File f = new File(MainController.Videos.get(i));
			        
			        Upload upload = tm.upload(bucketName,f.getName(),f);
			      
			        try {
			        	// Or you can block and wait for the upload to finish
			        	upload.waitForCompletion();
			        	System.out.println("Upload complete.");
			        } catch (AmazonClientException amazonClientException) {
			        	System.out.println("Unable to upload file, upload was aborted.");
			        	amazonClientException.printStackTrace();
			        }
			    }
		}
		}
	
*/