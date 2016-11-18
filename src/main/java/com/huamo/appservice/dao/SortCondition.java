package com.huamo.appservice.dao;



import com.huamo.appservice.common.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/10 0010.
 */
public class SortCondition {

    private List<SortEntity> conditions = new ArrayList<SortEntity>();

    public SortCondition() {
    }

    public void addCondition(String sortName, String sortRule) {
        SortEntity sortEntity = new SortEntity(sortName, sortRule);
        if (!conditions.contains(sortEntity)) {
            conditions.add(sortEntity);
        }
    }

    @Override
    public String toString() {
        String result = " ";
        for (int i = 0; i < conditions.size(); i++) {
            SortEntity sortEntity = conditions.get(i);
            String delimer = "";
            if (i != conditions.size() - 1) {
                delimer = ",";
            }
            result = result + sortEntity.getSortName() + " " + sortEntity.getSortRule() + delimer;
        }
        return result;
    }

    class SortEntity {
        private String sortName;
        private String sortRule;

        public SortEntity(String sortName, String sortRule) {
            if (sortRule != null) {
                sortRule = sortRule.toUpperCase();
            }
            if (!Constant.SortRuleType.SORT_RULE_ASC.equals(sortRule) &&
                    !Constant.SortRuleType.SORT_RULE_DESC.equals(sortRule))
                throw new UnsupportedOperationException("sort rule: " + sortRule + " is not right,asc and desc are the only value");
            this.sortName = sortName;
            this.sortRule = sortRule;
        }

        public String getSortName() {
            return sortName;
        }

        public void setSortName(String sortName) {
            this.sortName = sortName;
        }

        public String getSortRule() {
            return sortRule;
        }

        public void setSortRule(String sortRule) {
            this.sortRule = sortRule;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            SortEntity that = (SortEntity) o;
            if (that.sortName == null && this.sortName == null) return true;
            if (that.sortName != null && that.sortName.equals(this.sortName)) return true;
            return false;
        }
    }
}
