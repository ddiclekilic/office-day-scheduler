class DepartmentService {
  
    addDepartment(serviceCaller, requestBody,callback,errorCallBack){
    let headers= { 'Content-Type': 'application/json'};
        serviceCaller.post("/department", undefined, headers, requestBody, callback, errorCallBack)
    } 
    getDepartments(serviceCaller, queryParams, callback,errorCallBack){
        serviceCaller.get("/department", queryParams, undefined  ,  callback, errorCallBack)
    }
    updateDepartment(serviceCaller, requestBody,callback,errorCallBack){
        let headers= { 'Content-Type': 'application/json'};
        serviceCaller.update("/department", undefined, headers, requestBody, callback, errorCallBack)
    }
    deleteDepartment(serviceCaller, requestBody, callback,errorCallBack){
        let headers = {'Accept': 'application/json','Content-Type': 'application/json'};
        serviceCaller.delete("/department", undefined, headers  , requestBody, callback, errorCallBack)
    } 
}

export default new DepartmentService();