package railticket.validator;

public class UserValidator {
	
	public static void validateUserIdAndTrainNumber(int userId, String trainNumber) throws ValidatorException {
		if (userId == 0) {
			throw new ValidatorException(ErrorConstants.INVALID_USER_ID);
		}
		
		
	}
//	public static void main(String[] args) {
//		String email = "   ";
//		String password = null;
//		try {
//			validateUsernameAndPassword(email, password);
//			//dao.insertUser(email,password);
//		} catch (ValidatorException e) {
//			e.printStackTrace();
//		}
//	}
//}


public class ErrorConstants {
	public static final String INVALID_USER_ID
	= "Invalid UserId";
}

}
