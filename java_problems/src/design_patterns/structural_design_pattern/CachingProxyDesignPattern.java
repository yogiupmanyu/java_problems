package design_patterns.structural_design_pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * This example illustrates how the Proxy pattern can help to introduce lazy initialization and caching to a 3rd-party
 *  YouTube integration library.
	Caching results of a service with a proxy.
	The library provides us with the video downloading class. However, it’s very inefficient. 
	If the client application requests the same video multiple times, the library just downloads it over and over, instead of caching 
	and reusing the first downloaded file.
	The proxy class implements the same interface as the original downloader and delegates it all the work. 
	However, it keeps track of the downloaded files and returns the cached result when the app requests the same video multiple times.

 * */

//The interface of a remote service.
interface ThirdPartyYoutubeLib {
	public void listVideos();
	public void downloadVideo();
}

//The concrete implementation of a service connector. Methods
//of this class can request information from YouTube. The speed
//of the request depends on a user's Internet connection as
//well as YouTube's. The application will slow down if a lot of
//requests are fired at the same time, even if they all request
//the same information.
class ThirdPartyYoutubeClass implements ThirdPartyYoutubeLib {

	@Override
	public void listVideos() {
		System.out.println("Listing Videos !!!");
	}

	@Override
	public void downloadVideo() {
		System.out.println("Downloading Videos !!!");
	}
	
}

//To save some bandwidth, we can cache request results and keep
//them for some time. But it may be impossible to put such code
//directly into the service class. For example, it could have
//been provided as part of a third party library and/or defined
//as `final`. That's why we put the caching code into a new
//proxy class which implements the same interface as the
//service class. It delegates to the service object only when
//the real requests have to be sent.
class CachedYoutubeClass implements ThirdPartyYoutubeLib {

	
	private ThirdPartyYoutubeLib realService;
	private List<String> downloadCache = new ArrayList<String>(); // can initialize any time
	private List<String> listCache = new ArrayList<String>(); 
	
	public CachedYoutubeClass(ThirdPartyYoutubeLib realService) {
		this.realService = realService;
	}
	
	@Override
	public void listVideos() {
		if(listCache.contains("ExistName")) {
			System.out.println("List From Cache !!!");
		}else {
			realService.listVideos();
		}
	}

	@Override
	public void downloadVideo() {
		if(downloadCache.contains("ExistName")) {
			System.out.println("Download From Cache !!!");
		}else {
			realService.downloadVideo();
		}
	}
	
}

//The GUI class, which used to work directly with a service
//object, stays unchanged as long as it works with the service
//object through an interface. We can safely pass a proxy
//object instead of a real service object since they both
//implement the same interface.
class YoutubeManager {
	 protected ThirdPartyYoutubeLib service ;
	 
	 
	 YoutubeManager(ThirdPartyYoutubeLib service ) {
		 this.service = service;
	 }
     
	 public void listVideo() {
		 this.service.listVideos();
	 }

	 public void downloadVideo() {
		 this.service.downloadVideo();
	 }
	 
 

}


public class CachingProxyDesignPattern {
	 public static void main(String[] args)
	  {
		 ThirdPartyYoutubeLib service = new ThirdPartyYoutubeClass();
		 ThirdPartyYoutubeLib proxy = new CachedYoutubeClass(service);
		 YoutubeManager youtube = new YoutubeManager(service); 
		 
		 // call service at start then use proxy most of the time  
	  }
}
