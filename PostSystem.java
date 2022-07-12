import java.io.*;
import java.util.*;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class PostSystem {
	
	static public class PostService implements Comparable<PostService>{
		String title, content, userId, expireDate;
		int msgCnt;
		PostService(){}
		PostService(String title, String content, String userId, String expireDate) {
			this.title = title;
			this.content = content;
			this.userId = userId;
			this.expireDate = expireDate;
		}
		PostService(String title, String content, String userId, String expireDate, int msgCnt) {
			this.title = title;
			this.content = content;
			this.userId = userId;
			this.expireDate = expireDate;
			this.msgCnt = msgCnt;
		}

		public int compareTo(PostService o) {
			return this.expireDate.compareTo(o.expireDate);
		}
	}
	
	static HashMap<String, PostService> db_user = new HashMap<String, PostService>();
	static HashMap<Integer, PostService> db_message = new HashMap<Integer, PostService>();
	static HashMap<String, String> db_user_list = new HashMap<String, String>();


	static int messageCnt = 1;
	
    static class Insert implements HttpHandler {
    	String title, content, userId, expireDate;
    	
    	public Insert() {}
    	
		public Insert(String title, String content, String userId, String expireDate) {
			super();
			this.title = title;
			this.content = content;
			this.userId = userId;
			this.expireDate = expireDate;
		}



		public void handle(HttpExchange t) throws IOException {
			db_message.put(messageCnt, new PostService(this.title, this.content, this.userId, this.expireDate));
			String oneString = title + " " + content + " " + userId + " " + expireDate + "\n"; 
			db_user_list.put(this.userId, db_user_list.getOrDefault(this.userId, "") + oneString);
			messageCnt++;
			
			System.out.println(db_message.size() + " ");
			
            String response = "insert data done";
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

    static class Select implements HttpHandler {
    	int choiceSelection, messageIdx;
    	String userId, curTime;
    	
    	public Select() {}
    	
    	public Select(int choiceSelection, int messageIdx, String curTime) {
			super();
			this.choiceSelection = choiceSelection;
			this.messageIdx = messageIdx;
			this.curTime = curTime;
		}
    	public Select(int choiceSelection, String userId, String curTime) {
			super();
			this.choiceSelection = choiceSelection;
			this.userId = userId;
			this.curTime = curTime;
		}
		public void handle(HttpExchange t) throws IOException {
			StringBuilder select = new StringBuilder();
			if(this.choiceSelection == 1) {
				StringBuilder sb_selectAll = new StringBuilder();
				System.out.println(db_user_list.get(this.userId));
				select.append(db_user_list.get(this.userId));
				
			} else if(this.choiceSelection == 2) {
				
				if(db_message.get(this.messageIdx).expireDate.compareTo(this.curTime) < 0) {
					System.out.println("유효 기간이 만료 되었습니다.");
					select.append("유효 기간이 만료 되었습니다.");
				} else if(db_message.get(this.messageIdx).expireDate.compareTo(this.curTime) > 0) {
					System.out.println(db_message.get(this.messageIdx).title + " " + db_message.get(this.messageIdx).content + " " + 
							db_message.get(this.messageIdx).expireDate);
					select.append("제목: " + db_message.get(this.messageIdx).title + " \n내용: " + db_message.get(this.messageIdx).content + 
							" \n만료기간: " + db_message.get(this.messageIdx).expireDate);
				}				
			}
			
			//System.out.println(v1 + " " + v2);

			String response = select.toString();
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
    
    static class Delete implements HttpHandler {
    	int msgNum;
    	
    	public Delete() {}
    	
		public Delete(int msgNum) {
			this.msgNum = msgNum;
		}



		public void handle(HttpExchange t) throws IOException {
			db_message.remove(this.msgNum);
	        LocalDate now = LocalDate.now();
	        LocalTime now1 = LocalTime.now();
	        StringBuilder sb = new StringBuilder();
			sb.append(now).append(now1);
	        String curTime = sb.toString();
	        
	        for(int i: db_message.keySet()) {
	        	if(db_message.get(i).expireDate.compareTo(curTime) < 0) {
					System.out.println("만료된 데이터 삭제");
					db_message.remove(i);
				}
	        }

			System.out.println(db_message.size() + " ");

            String response = "delete index done";
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
    
	public static void main(String[] args) throws IOException {

        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        LocalDate now = LocalDate.now();
        LocalTime now1 = LocalTime.now();
        StringBuilder sb = new StringBuilder();
		sb.append(now).append(now1);
        String curTime = sb.toString();
        server.createContext("/insert", new Insert("arrangement tuesday meeting", "location is seoul", "boxer", curTime));
        server.createContext("/insert", new Insert("arrangement tuesday meetinga", "location is seoula", "boxer", curTime));

        // 1 해당 유저 전체 조회 2 해당 메시지 조회
        server.createContext("/select", new Select(2, 1, curTime));
        server.createContext("/select", new Select(1, "boxer", curTime));
        
        server.createContext("/delete", new Delete(1));


        server.setExecutor(null); // creates a default executor
        server.start();
        
        
        
	}

}
