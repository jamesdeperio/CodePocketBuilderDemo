package codepocket.jdp.codepocketbuilderdemo.global.model.obj.json

import com.google.gson.annotations.SerializedName

data class Atmosphere (
    @field:[SerializedName("rising")]
    var rising: Int = 0,
    @field:[SerializedName("humidity")]
    var humidity: Int = 0,
    @field:[SerializedName("visibility")]
    var visibility: Double = 0.toDouble(),
    @field:[SerializedName("pressure")]
    var pressure: Double = 0.toDouble()
)