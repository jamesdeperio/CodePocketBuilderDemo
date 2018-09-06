package codepocket.jdp.codepocketbuilderdemo.global.model.obj.xml

import com.tickaroo.tikxml.annotation.Attribute
import com.tickaroo.tikxml.annotation.Xml

@Xml(name = "guid")
data class Guid (
        @field:[Attribute(name = "isPermaLink")]
        var isPermaLink: Boolean = false
)