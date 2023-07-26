package indonesia.xml;

import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sskim
 */
@Getter
@Setter
@NoArgsConstructor
@XmlRootElement(name = "Line")
@XmlAccessorType(XmlAccessType.NONE)
public class Route {

    @XmlAttribute
    private String code;

    @XmlElement(name = "Name")
    private String name;

    @XmlElementWrapper(name = "Routes")
    @XmlElementRef
    private List<RouteNode> routeNodes;

    @XmlElementWrapper(name = "Sublines")
    @XmlElementRef
    private List<Subline> sublines;

    public void addRoute(RouteNode routeNode) {
        if (routeNodes == null) {
            routeNodes = new ArrayList<>();
        }
        routeNodes.add(routeNode);
    }

    public void addSublines(Subline subline) {
        if (sublines == null) {
            sublines = new ArrayList<>();
        }
        sublines.add(subline);
    }
}
