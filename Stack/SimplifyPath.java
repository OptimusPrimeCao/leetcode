package Stack;

import java.util.Stack;

public class SimplifyPath {
	public static String simplifyPath(String path) {
		if(path == null || path.isEmpty())
			return path;
		String[] dirs = path.split("/");
		Stack<String> dirStack = new Stack<String>();
		for(String s : dirs) {
			if(!s.isEmpty() && !s.equals(".")) 
				dirStack.push(s);
		}

		String result = "";
		int count = 0;
		while(!dirStack.isEmpty()) {
			String str = dirStack.pop();
			if(str.equals("..")) 
				count++;
			else {
				if(count == 0) 
					result = "/" + str + result;
				else
					count--;
			}
		}
		return result.isEmpty()?"/":result;
	}

	public static void main(String[] args) {
		System.out.println(simplifyPath("/abc/..."));
	}
}
