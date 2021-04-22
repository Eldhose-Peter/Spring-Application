import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';

class EldhoDesign extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>

`;
    }

    static get is() {
        return 'eldho-design';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(EldhoDesign.is, EldhoDesign);
