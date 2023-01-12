class RoleService {
  
    addRole(serviceCaller, requestBody,callback,errorCallBack){
    let headers= { 'Content-Type': 'application/json'};
        serviceCaller.post("/role", undefined, headers, requestBody, callback, errorCallBack)
    }
    getRoles(serviceCaller, queryParams, callback, errorCallBack){
        serviceCaller.get("/role", queryParams, undefined,  callback, errorCallBack)
    }
    updateRole(serviceCaller, requestBody, callback, errorCallBack){
        let headers= { 'Content-Type': 'application/json'};
        serviceCaller.update("/role", undefined, headers, requestBody, callback, errorCallBack)
    }
    deleteRole(serviceCaller, requestBody, callback, errorCallBack){
        let headers = {'Accept': 'application/json','Content-Type': 'application/json'};
        serviceCaller.delete("/role", undefined, headers, requestBody, callback, errorCallBack)
    } 
}

export default new RoleService();