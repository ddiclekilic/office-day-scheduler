class UserService {  
    getUsers(serviceCaller, queryParams, callback,errorCallBack){
        serviceCaller.get("/user", queryParams, undefined  ,  callback, errorCallBack)
    }
    getOneUser(url, serviceCaller, queryParams, callback,errorCallBack){
        serviceCaller.get(url, queryParams, undefined  ,  callback, errorCallBack)
    }
    updateUser(serviceCaller, requestBody,callback,errorCallBack){
        let headers= { 'Content-Type': 'application/json'};
        serviceCaller.update("/user", undefined, headers, requestBody, callback, errorCallBack)
    }
    deleteUser(serviceCaller, requestBody, callback,errorCallBack){
        let headers = {'Accept': 'application/json','Content-Type': 'application/json'};
        serviceCaller.delete("/user", undefined, headers  , requestBody, callback, errorCallBack)
    }
}

export default new UserService();