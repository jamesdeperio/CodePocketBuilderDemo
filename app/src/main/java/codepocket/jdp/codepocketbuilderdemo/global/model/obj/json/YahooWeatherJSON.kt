package codepocket.jdp.codepocketbuilderdemo.global.model.obj.json

import com.google.gson.annotations.SerializedName

data class YahooWeatherJSON (
        @field:[SerializedName("query")]
        var query: Query? = null
)