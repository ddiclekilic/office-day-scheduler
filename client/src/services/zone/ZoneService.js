class ZoneService {
  
    addZone(serviceCaller, requestBody, callback,errorCallBack){
    let headers= { 'Content-Type': 'application/json'};
        serviceCaller.post("/zone", undefined, headers, requestBody, callback, errorCallBack)
    }
    getZones(serviceCaller, queryParams, callback, errorCallBack){
        serviceCaller.get("/zone", queryParams, undefined,  callback, errorCallBack)
    }
    updateZone(serviceCaller, requestBody, callback, errorCallBack){
        let headers= { 'Content-Type': 'application/json'};
        serviceCaller.update("/zone", undefined, headers, requestBody, callback, errorCallBack)
    }
    deleteZone(serviceCaller, requestBody, callback, errorCallBack){
        let headers = {'Accept': 'application/json','Content-Type': 'application/json'};
        serviceCaller.delete("/zone", undefined, headers, requestBody, callback, errorCallBack)
    } 
}

export default new ZoneService();