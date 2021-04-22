import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;

/**
 * A Designer generated component for the eldho-design template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("eldho-design")
@JsModule("./src/eldho-design.js")
public class EldhoDesign extends PolymerTemplate<EldhoDesign.EldhoDesignModel> {

    /**
     * Creates a new EldhoDesign.
     */
    public EldhoDesign() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between EldhoDesign and eldho-design
     */
    public interface EldhoDesignModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
