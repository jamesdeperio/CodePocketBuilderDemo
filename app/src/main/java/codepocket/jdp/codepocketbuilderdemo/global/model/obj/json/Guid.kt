package codepocket.jdp.codepocketbuilderdemo.global.model.obj.json

import com.google.gson.annotations.SerializedName

data class Guid (
        @field:[SerializedName("isPermaLink")]
        var isPermaLink: Boolean = false
)