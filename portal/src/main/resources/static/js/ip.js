var myprovince = remote_ip_info['province']; 
var mycity = remote_ip_info['city'] 
var mydistrict = remote_ip_info['district']; 
$(function(){ 
    $("#city_1").citySelect({ 
        prov:myprovince,  
        city:mycity 
    }); 
}); 