package design_patterns.structural_design_pattern;

/** 
 * Provides a simple and easy to understand/user interface over a large and sophisticated body of code. 
 * */

//An example of isolating multiple dependencies within a single facade class.
//Instead of making your code work with dozens of the framework classes directly, you create a facade class which encapsulates 
//that functionality and hides it from the rest of the code. This structure also helps you to minimize the effort of upgrading to 
//future versions of the framework or replacing it with another one. The only thing you’d need to change in your app would be the 
//implementation of the facade’s methods.

// These are some of the classes of a complex 3rd-party video
// conversion framework. We don't control that code, therefore
// can't simplify it.

class VideoFile {
	
	VideoFile(String file){
		System.out.println("Convert to Video !!! " + file);
	}
	
}
class OggCompressionCodec {
	OggCompressionCodec(CodecFactory codec){
		
	}
}
class MPEG4CompressionCodec {
	MPEG4CompressionCodec(CodecFactory codec){
		
	}
}
class CodecFactory {
	
	private CodecFactory(VideoFile file) {
		System.out.println("Contract to Codact !!! ");
	}
	
	public static CodecFactory extract(VideoFile file) {
		return new CodecFactory(file);
	}
}

//We create a facade class to hide the framework's complexity
//behind a simple interface. It's a trade-off between
//functionality and simplicity.

class VideoConvertor {
	
	public void convert(String fileName , String format) {
		
		// use Video File
		VideoFile  file = new VideoFile(fileName);
		CodecFactory source = CodecFactory.extract(file);
		
		if(format.equals("Mp4")) 
			new MPEG4CompressionCodec(source);
		else
			new OggCompressionCodec(source);
		
		
		System.out.println("Complete method convert !!! ");
	}
}
public class FacadeDesignPattern {
	
	public static void main(String[] args) {
		// here now instead of using all the classes we create a single interface
		VideoConvertor convertor = new VideoConvertor();
		convertor.convert("File Name", "Mp4");
	}
}
