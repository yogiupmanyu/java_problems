package design_patterns.structural_design_pattern;


// FileDowloader ( this is Abstraction   
interface FileDownloaderAbstraction 
{
    public Object download(String path);
     
    public boolean store(Object object);
}

class FileDownloaderAbstractionImpl implements FileDownloaderAbstraction {
    
	
	// used to provide bridge connection with Implementation
    private FileDownloadImplementor provider = null;
 
    public FileDownloaderAbstractionImpl(FileDownloadImplementor provider) {
        super();
        this.provider = provider;
    }
 
    @Override
    public Object download(String path) 
    {
        return provider.downloadFile(path);
    }
 
    @Override
    public boolean store(Object object) 
    {
        return provider.storeFile(object);
    }
}


// this is Implementation ( used by Abstraction to provide functionality
interface FileDownloadImplementor
{
    public Object downloadFile(String path);
     
    public boolean storeFile(Object object);
}

class LinuxFileDownloadImplementor implements FileDownloadImplementor 
{
    @Override
    public Object downloadFile(String path) {
        return new Object();
    }
 
    @Override
    public boolean storeFile(Object object) {
        System.out.println("File downloaded successfully in LINUX !!");
        return true;
    }
}

class WindowsFileDownloadImplementor implements FileDownloadImplementor 
{
   @Override
   public Object downloadFile(String path) {
       return new Object();
   }

   @Override
   public boolean storeFile(Object object) {
       System.out.println("File downloaded successfully in WINDOWS !!");
       return true;
   }
}

public class BridgeDesignPattern {
	public static void main(String[] args) 
    {
        String os = "linux";
        FileDownloaderAbstraction downloader = null;
 
        switch (os) 
        {
            case "windows":
                downloader = new FileDownloaderAbstractionImpl( new WindowsFileDownloadImplementor() );
                break;
                 
            case "linux":
                downloader = new FileDownloaderAbstractionImpl( new LinuxFileDownloadImplementor() );
                break;
                 
            default:
                System.out.println("OS not supported !!");
        }
         
        Object fileContent = downloader.download("some path");
        downloader.store(fileContent);
    }
}
