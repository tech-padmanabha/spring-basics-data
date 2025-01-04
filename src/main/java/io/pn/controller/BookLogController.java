package io.pn.controller;

public class BookLogController {


}
//@PostMapping("/")
//public String uploadMultipartFile(@RequestParam("files") MultipartFile[] files, Model modal) {
//    try {
//        // Declare empty list for collect the files data
//        // which will come from UI
//        List<FileModal> fileList = new ArrayList<FileModal>();
//        for (MultipartFile file : files) {
//            String fileContentType = file.getContentType();
//            String sourceFileContent = new String(file.getBytes(), StandardCharsets.UTF_8);
//            String fileName = file.getOriginalFilename();
//            FileModal fileModal = new FileModal(fileName, sourceFileContent, fileContentType);
//
//            // Adding file into fileList
//            fileList.add(fileModal);
//        }