package neflis.neflisdemo.persistance;

import neflis.neflisdemo.model.UserApi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/*public interface UserRepository extends JpaRepository<UserApi, Long> {}
{
    private static UserApi list = new UserApi();

    static
    {
        list.getEmployeeList().add(new Employee(1, "Lokesh", "Gupta", "howtodoinjava@gmail.com"));
        list.getEmployeeList().add(new Employee(2, "Alex", "Kolenchiskey", "abc@gmail.com"));
        list.getEmployeeList().add(new Employee(3, "David", "Kameron", "titanic@gmail.com"));
    }

    public UserApi getAllUsers()
    {
        return list;
    }

        public void addUsers(UserApi user) {
        list.getUsersList().add(user);
    }
}*/