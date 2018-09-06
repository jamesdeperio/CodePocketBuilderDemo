package codepocket.jdp.codepocketbuilderdemo.global.model.obj.json

import com.google.gson.annotations.SerializedName

data class Astronomy (
    @field:[SerializedName("sunrise")]
    var sunrise: String? = null,
    @field:[SerializedName("sunset")]
    var sunset: String? = null
)