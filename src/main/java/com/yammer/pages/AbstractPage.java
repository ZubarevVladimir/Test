package com.yammer.pages;

import com.yammer.utils.Browser;

class AbstractPage {

    Browser browser;

    AbstractPage() {
        try {
            browser = Browser.getBrowserInstance();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
