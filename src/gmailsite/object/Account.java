package gmailsite.object;

public class Account {

	private String username = null;
	private String password = null;
	private String staySignedInOption = null;
	
	public static class Builder {
		private String username;
		private String password;
		private String staySignedInOption;
		
		public Builder username (String username){
			this.username = username;
			return this;
		}
		
		public Builder password (String password){
			this.password = password;
			return this;
		}
		
		public Builder staySignedInOption (String staySignedInOption){
			this.staySignedInOption = staySignedInOption;
			return this;			
		}
		
		public Account build() {
			return new Account(this);
		}
	}
	
	private Account(Builder builder){
		username = builder.username;
		password = builder.password;
		staySignedInOption = builder.staySignedInOption;
	}
	
	public String getUsername(){
		return this.username;
	}
	
	public String getPassword(){
		return this.password;
	}
	
	public String getStaySignedInOption(){
		return this.staySignedInOption;
	}

}
