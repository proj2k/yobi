package models.enumeration;

import play.i18n.Messages;

import java.util.*;

public enum NotificationType {

    NEW_ISSUE("notification.type.new.issue", 1),
    NEW_POSTING("notification.type.new.posting", 2),
    NEW_PULL_REQUEST("notification.type.new.pull.request", 3),
    ISSUE_STATE_CHANGED("notification.type.issue.state.changed", 4),
    ISSUE_ASSIGNEE_CHANGED("notification.type.issue.assignee.changed", 5),
    PULL_REQUEST_STATE_CHANGED("notification.type.pull.request.state.changed", 6),
    NEW_COMMENT("notification.type.new.comment", 7),
    NEW_SIMPLE_COMMENT("notification.type.new.simple.comment", 8);

    private String descr;

    private int order;

    NotificationType(String messageKey, int order) {
        this.descr = Messages.get(messageKey);
        this.order = order;
    }

    public String getDescr() {
        return descr;
    }

    public int getOrder() {
        return order;
    }

    public static final List<NotificationType> notiTypes;

    static {
        notiTypes = Arrays.asList(NotificationType.values());
        Collections.sort(notiTypes, new Comparator<NotificationType>() {
            @Override
            public int compare(NotificationType o1, NotificationType o2) {
                return o1.getOrder() - o2.getOrder();
            }
        });
    }

}
