<template>
  <a-cascader
    v-model:value="state"
    v-bind="$attrs"
    :options="tree"
    change-on-select
    @change="handleChange"
    style="width: 100%"
  />
</template>
<script lang="ts">
  import { defineComponent, ref, watch } from 'vue';
  import { useRuleFormItem } from '/@/hooks/component/useFormItem';
  import { useAttrs } from '/@/hooks/core/useAttrs';
  import { useDictStore } from '/@/store/modules/dict';
  import { TreeSelectModel } from '/@/api/model/selectModel';
  import { propTypes } from '/@/utils/propTypes';

  export default defineComponent({
    name: 'DictCascader',
    props: {
      dictType: propTypes.string,
      value: propTypes.array,
    },
    emits: ['options-change', 'change', 'update:value'],
    setup(props, { emit }) {
      const emitData = ref<any[]>([]);
      const attrs = useAttrs();
      const dictStore = useDictStore();
      const tree = ref<TreeSelectModel[]>([]);

      // Embedded in the form, just use the hook binding to perform form verification
      const [state] = useRuleFormItem(props, 'value', 'change', emitData);

      watch(
        () => props.dictType,
        () => {
          getTree();
        },
      );

      function getTree() {
        tree.value = dictStore.selectTree(props.dictType);
      }

      function handleChange(value) {
        emitData.value = value;
        emit('update:value', value);
      }

      getTree();

      return { state, attrs, tree, handleChange };
    },
  });
</script>
