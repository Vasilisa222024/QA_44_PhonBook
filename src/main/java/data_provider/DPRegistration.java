package data_provider;

import dto.UserDto;
import org.testng.annotations.DataProvider;

import java.util.Random;

import static utils.RandomUtils.generateString;

public class DPRegistration {
    @DataProvider
    public UserDto[] addNewRegistration(){
        //String email = generateString(12);
        UserDto user1 = new UserDto("email.com", "Qartrt234$");


        UserDto user2 = new UserDto( new Random().nextInt(1000)+"email@gmailcom", "Qartrt234$");
        return  new UserDto[]{user1,user2};
    }

}
