package com.imooc.logo.controller;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class UploadController extends AbstractBaseController
{	
	@GetMapping("/preupload")	
	public String preupload() 
	{					
		return "upload";
	}
	
	@PostMapping("/upload")
	@ResponseBody
	public String upload(String name,HttpServletRequest request) throws IOException 
	{	
		if(request instanceof MultipartHttpServletRequest) 
		{
			MultipartHttpServletRequest mrequest=(MultipartHttpServletRequest)request;
			List<MultipartFile> files = mrequest.getFiles("photo");
			Iterator<MultipartFile> iterator = files.iterator();
			while(iterator.hasNext()) 
			{
				MultipartFile file=iterator.next();
				if(file!=null) 
				{
					System.out.println(file.getName());
					System.out.println(file.getContentType());
					System.out.println(file.getSize());
				}
				
			}
			
		}
		return "upload";
	}
	
	@PostMapping("/upload11")
	@ResponseBody
	public String upload11(String name,MultipartFile photo) throws IOException 
	{	
		
			System.out.println(photo.getName());
			System.out.println(photo.getContentType());
			System.out.println(photo.getSize());
		    String path="C:\\\\pic";
			File file = new File(path);
	        if (!file.exists()) {
	            file.mkdirs();
	        }
	        FileInputStream fileInputStream = (FileInputStream) photo.getInputStream();
	        String fileName = "hello" + ".png";
	        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path + File.separator + fileName));
	        byte[] bs = new byte[1024];
	        int len;
	        while ((len = fileInputStream.read(bs)) != -1) {
	            bos.write(bs, 0, len);
	        }
	        bos.flush();
	        bos.close();
	
		
		return "upload";
	}

}
