class ScheduleService {
  
    addSchedule(serviceCaller, requestBody,callback,errorCallBack){
    let headers= { 'Content-Type': 'application/json'};
        serviceCaller.post("/schedule", undefined, headers, requestBody, callback, errorCallBack)
    }
    getSchedules(serviceCaller, queryParams, callback,errorCallBack){
        serviceCaller.get("/schedule", queryParams, undefined  ,  callback, errorCallBack)
    }
    updateSchedule(serviceCaller, requestBody,callback,errorCallBack){
        let headers= { 'Content-Type': 'application/json'};
        serviceCaller.update("/schedule", undefined, headers, requestBody, callback, errorCallBack)
    }
    deleteSchedule(erviceCaller, requestBody, callback,errorCallBack){
        let headers = {'Accept': 'application/json','Content-Type': 'application/json'};
        serviceCaller.delete("/schedule", undefined, headers  , requestBody, callback, errorCallBack)
    } 
}

export default new ScheduleService();