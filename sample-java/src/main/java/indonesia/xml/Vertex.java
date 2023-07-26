package indonesia.xml;

import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author sskim
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "Vertex")
public class Vertex {
    @XmlAttribute
    private String cx;
    @XmlAttribute
    private String cy;
}
