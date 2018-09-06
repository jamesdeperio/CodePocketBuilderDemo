package codepocket.jdp.codepocketbuilderdemo.global.model.obj.json

import com.google.gson.annotations.SerializedName

data class Results(
        @field:[SerializedName("channel")]
        var channel: Channel? = null
)