// Get Json data from csv_file table
var patientTimelines = new Array();

/*
$.ajax({
		type: "GET",
		url: "/analysis/getPatientTimelines",
		async: false,
		success : function(text)
		{
			patientTimelines = text.data;
		}
	});
*/


//console.log(patientTimelines);
//get two arrays from GetAggregationDataFromCSV(time points and feature values)
$.ajax({
	type: "GET",
	url: "/service/getData",
	async: false,
	success : function(text)
	{
		data_points = text.data;
	}
});

var time = data_points.time;
var value_30 = data_points.value_30;
var value_60 = data_points.value_60;
var value_120 = data_points.value_120;

//this is the number of time points of this patient file
var length = time.length;

console.log(data_points);
console.log(time);

$('#single_Chart').append('<canvas id="myChart"></canvas>');

var datasets = []; // for store points

//max range: calculate this value from csv to adjust y axis labels
var max = 1600;


//change range to file size later
var labels = [];
for(i =0; i < max; i += 1)
{
  labels.push(i);	
}

/*
//aggregate 30s data and put them in an array 
function agg_30s_mean(data,max)
{
	var aggregated_arr = [];
	
	//this var should be set to 0 at each aggregation time point
	var temp_sum = 0;
	//this var should be set to temp_sum at each agg point
	var temp_sum_n = 0;
	
	var x =0;         
	
	for(i = 0; i < max;i++)
	{
	   temp_sum += data[i];
	   x = i % 30;
	   if(i != 0 && x == 0)
	   {
		  temp_sum_n = temp_sum + 0;
		  aggregated_arr.push(temp_sum/30 + 0);
		  temp_sum = 0;
	   }
	   else
	   {
		  aggregated_arr.push(temp_sum_n );
	   }
		
	}
	
	return aggregated_arr;

}
*/

/*
//aggregate 60s data and put them in an array 
function agg_60s_mean(data,max)
{
	var aggregated_arr = [];
	
	//this var should be set to 0 at each aggregation time point
	var temp_sum = 0;
	//this var should be set to temp_sum at each agg point
	var temp_sum_n = 2;
	
	for(i = 0; i < max;i++)
	{
	   temp_sum += data[i];
	   if(i != 0 && i%60 == 0)
	   {
		  temp_sum_n = temp_sum + 2;
		  aggregated_arr.push(temp_sum/60 + 2);
		  temp_sum = 0;
	   }
	   else
	   {
		  aggregated_arr.push(temp_sum_n);
	   }
		
	}
	
	return aggregated_arr;

}


//aggregate 120s data and put them in an array 
function agg_900s_mean(data,max)
{
	var aggregated_arr = [];
	
	//this var should be set to 0 at each aggregation time point
	var temp_sum = 0;
	//this var should be set to temp_sum at each agg point
	var temp_sum_n = 4;
	
	for(i = 0; i < max;i++)
	{
	   temp_sum += data[i];
	   if(i != 0 && i%900 == 0)
	   {
		  temp_sum_n = temp_sum + 4;
		  aggregated_arr.push(temp_sum/900 + 4);
		  temp_sum = 0;
		   
	   }
	   else
	   {
		  aggregated_arr.push(temp_sum_n);
	   }
		
	}
	
	return aggregated_arr;

}

var thirty_agg_data = agg_30s_mean(value,length);
var sixty_agg_data = agg_60s_mean(value,length);
var nine_hundred_agg_data = agg_900s_mean(value,length);
*/




datasets.push({
    
    data: value_30,
    label: "30s",
    borderColor: "#8e5ea2",
    fill: false
  
})


datasets.push({
    
    data: value_60,
    label: "60s",
    borderColor: "#8e5eff",
    fill: false
  
})


datasets.push({
    
    data: value_120,
    label: "2min",
    borderColor: "#7e5aff",
    fill: false
  
})


//aggregation level
var yLabels = 
    {
	    0 : '30s', 2 : '60s', 4: '2min'
	}

var allGraph = new Chart($("#myChart"), {
    type : 'line',
    data : {
    	 labels: labels,
        datasets : datasets
    },
    options : {
        legend:{
            onClick : function(event, legendItem) {
                allGraph.resetZoom();

                var index = legendItem.datasetIndex;
                var ci = this.chart;
                var meta = ci.getDatasetMeta(index);
                meta.hidden = meta.hidden === null? !ci.data.datasets[index].hidden : null;
                ci.update();
            }
        },
        bezierCurve : true,
        bezierCurveTension: 1,
        

        
        events : [ "mousemove", "touchstart", "touchmove", "touchend", "click"
        ],

        
        scales: {
            yAxes: [{
                ticks: {
                    callback: function(value, index, values) {
                        // for a value (tick) equals to 8
                        return yLabels[value];
                        // 'junior-dev' will be returned instead and displayed on your chart
                    }
                }
            }]
        },
        
        pan:{
            enabled:true,
            mode: 'xy',
            speed: 1
        },
        zoom:{
            enabled:true,
            mode: 'x'
        }
    }
});




