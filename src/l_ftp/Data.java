package l_ftp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Data implements Serializable{
	public static long serialVersionUID = 3L;
	
	List<String> fileName = new ArrayList<String>();
	List<Long> fileSize = new ArrayList<Long>();
	
	int port;
}
