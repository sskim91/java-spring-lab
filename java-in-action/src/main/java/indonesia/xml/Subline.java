package indonesia.xml;

import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author sskim
 */
@ToString
@Getter
@Setter
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "Subline")
public class Subline {

    @XmlAttribute
    private String code;

    @XmlElement(name = "Label")
    private String label;

    @XmlElementWrapper(name = "Routes")
    @XmlElementRef
    private List<SublineRoute> routes;
}
