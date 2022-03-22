package com.example.retrofitexample;

public class LoginRequest {
    Data data;
    Result result;

    public LoginRequest(Data data, Result result) {
        this.data = data;
        this.result = result;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}

class Data {
    String userName;
    String firstName;
    String lastName;
    String email;
    String phone;
    String userCode;

    public Data(String userName, String firstName, String lastName, String email, String phone, String userCode) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }
}

class Result {
    String ErrNo;
    String ErrMsg;

    public Result(String errNo, String errMsg) {
        ErrNo = errNo;
        ErrMsg = errMsg;
    }

    public String getErrNo() {
        return ErrNo;
    }

    public void setErrNo(String errNo) {
        ErrNo = errNo;
    }

    public String getErrMsg() {
        return ErrMsg;
    }

    public void setErrMsg(String errMsg) {
        ErrMsg = errMsg;
    }
}
