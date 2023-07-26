package indonesia.xml;

import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author sskim
 */
@ToString
@Getter
@Setter
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "Node")
public class RouteStationNode {

    @XmlAttribute
    private String type;

    @XmlAttribute
    private String code;

    @XmlElement(name = "Position")
    private String position;

    @XmlElement(name = "Attribute")
    private String attribute;
}
