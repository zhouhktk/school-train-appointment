package com.st.controller;

import com.st.data.BigStaff;
import com.st.data.Code;
import com.st.data.ResponseVo;
import com.st.entity.Staff;
import com.st.service.DepartmentService;
import com.st.service.StaffService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * 员工控制器
 *
 * @author : zhoufeng
 * @date : 2020/8/18
 */
@RestController
@RequestMapping("/staff")
@Scope("session")
public class StaffController {
    @Autowired
    private StaffService staffService;
    @Autowired
    private DepartmentService departmentService;

    /**
     * 获取单个员工的信息
     *
     * @param number
     * @return
     */
    @GetMapping("/getinfo")
    public ResponseVo getinfo(@RequestParam("number") String number) {
        Staff staff = staffService.selectByNumber(number);
        if (staff != null) {
            String departName = departmentService.selectByNumber(staff.getDepartNumber()).getDepartName();
            BigStaff bigStaff = new BigStaff();
            bigStaff.setDepartName(departName);
            BeanUtils.copyProperties(staff, bigStaff);
            return new ResponseVo(Code.SUCCESS, "查询员工信息成功！", bigStaff);
        } else {
            return new ResponseVo(Code.NOTFOUND, "未找到该员工信息！", null);
        }
    }

    // /**
    //  * 将Staff对象的信息复制到BigStaff对象中
    //  * @param list
    //  * @return
    //  */
    // private List<BigStaff> addDepartNameValue(List<Staff> list){
    //     List<BigStaff> bs = new ArrayList<>();
    //     for (Staff staff : list) {
    //         BigStaff bigStaff = new BigStaff();
    //         BeanUtils.copyProperties(staff, bigStaff);
    //         String departName = departmentService.selectByNumber(staff.getDepartNumber()).getDepartName();
    //         bigStaff.setDepartName(departName);
    //         bs.add(bigStaff);
    //     }
    //     return bs;
    // }

    /**
     * 员工登录
     * @param staff
     * @param session
     * @return
     */
    @PostMapping("/login")
    public ResponseVo login(@RequestBody Staff staff, HttpSession session) {
        if (staff.getNumber() != null && staff.getPassword() != null) {
            Staff sf = staffService.selectByNumber(staff.getNumber());
            if (sf != null && sf.getStatus() != 2
                    && sf.getPassword().equals(DigestUtils.md5DigestAsHex(staff.getPassword().getBytes()))) {
                session.setAttribute("staff", sf);
                return new ResponseVo(Code.SUCCESS, "登录成功！", sf);
            } else {
                return new ResponseVo(Code.FAILED, "用户名或密码错误！", null);
            }
        } else {
            return new ResponseVo(Code.FAILED, "用户名或密码不能为空！", null);
        }
    }

    /**
     * 登出
     * @param session
     * @return
     */
    @GetMapping("/logout")
    public ResponseVo logout(HttpSession session) {
        session.removeAttribute("staff");
        return new ResponseVo(Code.SUCCESS, "注销成功！", null);
    }

    /**
     * 修改员工密码
     * @param sf
     * @return
     */
    @PostMapping("/changepsd")
    public ResponseVo changePassword(@RequestBody Staff sf) {
        Staff staff = null;
        if (sf.getNumber() != null && sf.getPassword() != null) {
            staff = staffService.selectByNumber(sf.getNumber());
            if (staff != null) {
                String ps = DigestUtils.md5DigestAsHex(sf.getPassword().getBytes());
                staff.setPassword(ps);
            } else {
                return new ResponseVo(Code.FAILED, "该员工编号不存在!", null);
            }
        } else {
            return new ResponseVo(Code.FAILED, "新密码不能为空！", null);
        }
        int res = staffService.update(staff);
        if (res != 0) {
            return new ResponseVo(Code.SUCCESS, "修改密码成功！", null);
        } else {
            return new ResponseVo(Code.FAILED, "修改密码失败！", null);

        }
    }

    /**
     * 修改个人信息
     * @param staff
     * @return
     */
    @PostMapping("/changeinfo")
    public ResponseVo changeInfo(@RequestBody Staff staff){
        int res = staffService.update(staff);
        if (res!=0){
            return new ResponseVo(Code.SUCCESS, "修改员工信息成功！", null);
        }else {
            return new ResponseVo(Code.FAILED, "修改员工信息失败！", null);
        }
    }
}
