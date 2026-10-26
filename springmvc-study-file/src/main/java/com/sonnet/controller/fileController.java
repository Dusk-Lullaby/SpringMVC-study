package com.sonnet.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class fileController {

    // 文件下载功能
    @RequestMapping("/download")
    public ResponseEntity<byte[]> downloadFile(HttpSession httpSession) throws IOException {
        // 获取ServletContext对象
        ServletContext servletContext = httpSession.getServletContext();
        // 根据ServletContext对象获取文件的真实路径
        String realPath = servletContext.getRealPath("/images/rose.jpg");
        System.out.println(realPath);
        // 创建一个输入流
        InputStream inputStream = new FileInputStream(realPath);
        // 创建字节数组对象
        byte[] bytes = new byte[inputStream.available()];
        // 将流读到字节数组中
        inputStream.read(bytes);
        // 设置响应头信息
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment;filename=rose.jpg");
        // 设置响应状态码
        HttpStatus status = HttpStatus.OK;
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers, status);
        // 关闭输入流
        inputStream.close();
        return responseEntity;
    }

    /**
     * 使用SpringMVC的方式进行文件上传操作
     * @param httpServletRequest
     * @param upload
     * @return
     * @throws Exception
     */
    @RequestMapping("upload")
    public String fileUpload(HttpServletRequest httpServletRequest, MultipartFile upload) throws Exception {
        // 获取文件上传的目录
        String path = httpServletRequest.getSession().getServletContext().getRealPath("/upload");
        System.out.println("path:" + path);
        // 根据文件路径创建File对象，如果file对象不存在，则自动创建
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        // 获取文件上传的名称
        String originalFilename = upload.getOriginalFilename();
        // 执行文件上传操作
        upload.transferTo(new File(path, originalFilename));
        return "success";
    }

/*
    // 基于传统servlet技术进行文件上传
    @RequestMapping("upload")
    public String fileUpload(HttpServletRequest httpServletRequest) throws Exception {
        // 获取文件上传的目录
        String path = httpServletRequest.getSession().getServletContext().getRealPath("/upload");
        System.out.println("path:" + path);
        // 根据文件路径创建File对象，如果file对象不存在，则自动创建
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        // 创建磁盘文件项工厂
        DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
        // 根据磁盘文件项工厂创建文件上传对象
        ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
        // 根据FileUpLoad对象解析文件上传的请求，获取FileItem对象的集合
        List<FileItem> fileItems = fileUpload.parseRequest(httpServletRequest);
            // 表单项分为2种，一种是文件上传的表单项 type="file"
            // 还有一种是普通表单项 比如文本表单控件 密码表单控件 单元按钮 复选框按钮...
        for (FileItem fileItem : fileItems) {
            if (fileItem.isFormField()) {
                // 普通表单项，不做任何操作
            } else {
                // 获取文件的名称
                String name = fileItem.getName();
                // 执行文件上传
                fileItem.write(new File(path, name));
                // 删除临时文件
                fileItem.delete();
            }
        }
        return "success";
    }
*/
}