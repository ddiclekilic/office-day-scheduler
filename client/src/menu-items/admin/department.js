// assets
import KeyboardArrowRightIcon from '@mui/icons-material/KeyboardArrowRight';
// constant
const icons = { KeyboardArrowRightIcon };

// ==============================|| DEPARTMENT MENU ITEMS ||============================== //

const department = {
    id: 'department-group',
    type: 'group',
    children: [
        {
            id: 'department',
            title: 'Department List',
            type: 'item',
            url: '/admin/department',
            icon: icons.KeyboardArrowRightIcon,
            breadcrumbs: false
        }
    ]
};

export default department;
