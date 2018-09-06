package codepocket.jdp.codepocketbuilderdemo.global.model.obj.json

import com.google.gson.annotations.SerializedName

data class Units (
    @field:[SerializedName("distance")]
    var distance: String? = null,
    @field:[SerializedName("temperature")]
    var temperature: String? = null,
    @field:[SerializedName("pressure")]
    var pressure: String? = null,
    @field:[SerializedName("speed")]
    var speed: String? = null
)