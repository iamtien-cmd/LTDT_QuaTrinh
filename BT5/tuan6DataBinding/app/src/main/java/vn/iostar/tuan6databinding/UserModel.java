package vn.iostar.tuan6databinding;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;


public class UserModel extends BaseObservable {
    // firstName và lastName.
    private String firstName;
    private String lastName;
// tạo constructor, getter và setter

    public UserModel(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    @Bindable
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        notifyPropertyChanged(BR.firstName);
    }
    @Bindable
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        notifyPropertyChanged(BR.lastName);
    }
}
