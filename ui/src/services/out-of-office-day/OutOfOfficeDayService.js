class OutOfOfficeDayService {
  
    addOutOfOfficeDay(serviceCaller, requestBody,callback,errorCallBack){
    let headers= { 'Content-Type': 'application/json'};
        serviceCaller.post("/outofofficeday", undefined, headers, requestBody, callback, errorCallBack)
    } 
    getOutOfOfficeDays(serviceCaller, queryParams, callback,errorCallBack){
        serviceCaller.get("/outofofficeday", queryParams, undefined,  callback, errorCallBack)
    }
    updateOutOfOfficeDay(serviceCaller, requestBody, callback, errorCallBack){
        let headers= { 'Content-Type': 'application/json'};
        serviceCaller.update("/outofofficeday", undefined, headers, requestBody, callback, errorCallBack)
    }
    deleteOutOfOfficeDay(serviceCaller, requestBody, callback, errorCallBack){
        let headers = {'Accept': 'application/json','Content-Type': 'application/json'};
        serviceCaller.delete("/outofofficeday", undefined, headers, requestBody, callback, errorCallBack)
    } 
}

export default new OutOfOfficeDayService();