package codepocket.jdp.codepocketbuilderdemo.global.model.obj.json

import com.google.gson.annotations.SerializedName

data class Wind (
    @field:[SerializedName("chill")]
    var chill: Int = 0,
    @field:[SerializedName("speed")]
    var speed: Int = 0,
    @field:[SerializedName("direction")]
    var direction: Int = 0
)