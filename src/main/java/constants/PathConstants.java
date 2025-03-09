package constants;

public interface PathConstants {
	//test data excel path
	public String SAMPLEDATA_PATH = System.getProperty("user.dir")+ "//src//main//resources//excelData//testData//SampleData.xlsx";
	public String CHROME_DRIVER_PATH = System.getProperty("user.dir")+"\\src\\main\\resources\\driver\\chromedriver.exe";
	public static String filePath_WINDOWS = System.getProperty("user.dir") + "\\src\\main\\resources\\CheckList Data";
	public static String filePath_MAC = "src/main/resources/CheckList Data";
	public static String WINDOWS_UploadFilesPath = System.getProperty("user.dir") + "\\src\\main\\resources\\uploadFiles";
	public static String MAC_UploadFilesPath = "src/main/resources/uploadFiles";
	public static String FILES_DOWNLOAD_FOLDER_PATH = System.getProperty("user.dir")+"/src/main/resources/downloadFiles";
	public static String FILES_DOWNLOAD_FOLDER_PATH_WINDOWS = System.getProperty("user.dir")+"\\src\\main\\resources\\downloadFiles";
	public static String UPLOAD_FILE_S3 ="src\\main\\resources\\uploadFiles";
	public static String UPLOAD_FILE_S3_MAC = "src/main/resources/uploadFiles";

}
