class CalendarService {
  
    addCalendar(serviceCaller, requestBody,callback,errorCallBack){
    let headers= { 'Content-Type': 'application/json'};
        serviceCaller.post("/calendar", undefined, headers, requestBody, callback, errorCallBack)
    }
    getCalendars(serviceCaller, queryParams, callback,errorCallBack){
        serviceCaller.get("/calendar", queryParams, undefined  ,  callback, errorCallBack)
    }
    updateCalendar(serviceCaller, requestBody,callback,errorCallBack){
        let headers= { 'Content-Type': 'application/json'};
        serviceCaller.update("/calendar", undefined, headers, requestBody, callback, errorCallBack)
    }
    deleteCalendar(serviceCaller, requestBody, callback,errorCallBack){
        let headers = {'Accept': 'application/json','Content-Type': 'application/json'};
        serviceCaller.delete("/calendar", undefined, headers  , requestBody, callback, errorCallBack)
    } 
}

export default new CalendarService();