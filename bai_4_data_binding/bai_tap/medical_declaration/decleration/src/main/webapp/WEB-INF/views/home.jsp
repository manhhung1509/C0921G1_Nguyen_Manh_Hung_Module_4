<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        table, td {
            border: 1px solid darkgrey;
            height: 60px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th {
            border: 1px solid darkgrey;
            height: 45px;
            background: #eeeeee;
        }

        button {
            background-color:#31c41f;
            margin-left:auto;
            margin-right:auto;
            display:block;
            border-radius: 30px;
            width: 121px;
            height: 43px;
            border: solid 1px #31c41f;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="col-lg-12">
        <div class="row">
            <div class="col-lg-12">
                <p style="text-align: center; font-weight: bold; font-size: 20px">Tờ khai y tế</p>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <p style="text-align: center; font-weight: bold; font-size: 18px">
                    Đây là tài liệu quan trọng, thông tin của anh/chị sẽ giúp cơ quan y tế liên lạc khi cần thiết để
                    phòng
                    chống
                    dịch bệnh truyền nhiễm
                </p>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <p style="text-align: center; font-weight: bold; font-size: 14px; color: red">
                    Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể xử lý hình sự
                </p>
            </div>
        </div>
        <form:form action="/create" modelAttribute="commonInformation">
            <div class="row">
                <div class="col-lg-12">
                    <p style="margin-top: 12px; margin-bottom: 14px">
                        Họ tên(ghi chữ IN HOA) <span style="font-style: italic; color: red">(*)</span>
                    </p>
                    <form:input path="name" cssStyle="width: 100%; height: 40px; border-radius: 6px; margin-top: -9px"/>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-4">
                    <p style="margin-top: 12px; margin-bottom: 14px">
                        Năm sinh <span style="font-style: italic; color: red">(*)</span>
                    </p>
                    <form:select path="birthday" cssStyle="width: 100%; height: 32px; border-radius: 6px; margin-top: -6px">
                        <form:option value="-1" label="------- Select One -------" />
                        <form:options items="${yearList}" />
                    </form:select>
                </div>
                <div class="col-lg-4">
                    <p style="margin-top: 12px; margin-bottom: 14px">
                        Giới tính <span style="font-style: italic; color: red">(*)</span>
                    </p>
                    <form:select path="gender" cssStyle="width: 100%; height: 32px; border-radius: 6px; margin-top: -6px">
                        <form:option value="none" label="------- Select One -------" />
                        <form:options items="${genderList}" />
                    </form:select>
                </div>
                <div class="col-lg-4">
                    <p style="margin-top: 12px; margin-bottom: 14px">
                        Quốc tịch <span style="font-style: italic; color: red">(*)</span>
                    </p>
                    <form:select path="country" cssStyle="width: 100%; height: 32px; border-radius: 6px; margin-top: -6px">
                        <form:option value="none" label="------- Select One -------" />
                        <form:options items="${countryList}" />
                    </form:select>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <p style="margin-top: 12px; margin-bottom: 14px">
                        Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác <span
                            style="font-style: italic; color: red">(*)</span>
                    </p>
                    <form:input path="id" cssStyle="width: 100%; height: 40px; border-radius: 6px; margin-top: -9px"/>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-5">
                    <p style="margin-top: 12px; margin-bottom: 2px">
                        Thông tin đi lại <span style="font-style: italic; color: red">(*)</span>
                    </p>
                    <form:radiobuttons path="travelInformation.vehicle" items="${vehicleList}" cssStyle="margin-left: 5px"/>
                </div>
                <div class="col-lg-7"></div>
            </div>
            <div class="row">
                <div class="col-lg-6">
                    <p style="margin-top: 12px; margin-bottom: 14px">
                        Số hiệu phương tiện
                    </p>
                    <form:input path="travelInformation.vehicleNumber" cssStyle="width: 100%; height: 40px; border-radius: 6px; margin-top: -9px"
                           placeholder=" VD:VN123"/>
                </div>
                <div class="col-lg-6">
                    <p style="margin-top: 12px; margin-bottom: 14px">
                        Số ghế
                    </p>
                    <form:input path="travelInformation.seatNumber" cssStyle="width: 100%; height: 40px; border-radius: 6px; margin-top: -9px"/>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6">
                    <p style="margin-top: 12px; margin-bottom: 14px">
                        Ngày khởi hành <span style="font-style: italic; color: red">(*)</span>
                    </p>
                        <form:input path="travelInformation.dateStart" type="date" cssStyle="width: 100%; height: 40px; border-radius: 6px; margin-top: -9px"/>
                </div>
                <div class="col-lg-6">
                    <p style="margin-top: 12px; margin-bottom: 14px">
                        Ngày kết thúc <span style="font-style: italic; color: red">(*)</span>
                    </p>
                    <form:input path="travelInformation.dateEnd" type="date" cssStyle="width: 100%; height: 40px; border-radius: 6px; margin-top: -9px"/>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <p style="margin-top: 12px; margin-bottom: 14px">
                        Trong vòng 14 ngày qua, anh/chị có đến tỉnh/thành phố nào? <span
                            style="font-style: italic; color: red">(*)</span>
                    </p>
                    <form:textarea path="travelInformation.destination" cssStyle="width: 100%; height: 40px; border-radius: 6px; margin-top: -9px"/>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-4">
                    <p style="margin-top: 12px; margin-bottom: -6px">
                        Địa chỉ liên lạc
                    </p>
                    <p style="margin-top: 12px; margin-bottom: 14px">
                        Tỉnh/Thành <span style="font-style: italic; color: red">(*)</span>
                    </p>
                    <form:select path="city" cssStyle="width: 100%; height: 32px; border-radius: 6px; margin-top: -6px">
                        <form:option value="none" label="------- Select One -------" />
                        <form:options items="${cityList}" />
                    </form:select>
                </div>
                <div class="col-lg-4">
                    <p style="margin-top: 42px; margin-bottom: 14px">
                        Quận/Huyện <span style="font-style: italic; color: red">(*)</span>
                    </p>
                    <form:select path="district" cssStyle="width: 100%; height: 32px; border-radius: 6px; margin-top: -6px">
                        <form:option value="none" label="------- Select One -------" />
                        <form:options items="${districtList}" />
                    </form:select>
                </div>
                <div class="col-lg-4">
                    <p style="margin-top: 42px; margin-bottom: 14px">
                        Phường/Xã <span style="font-style: italic; color: red">(*)</span>
                    </p>
                    <form:select path="commune" cssStyle="width: 100%; height: 32px; border-radius: 6px; margin-top: -6px">
                        <form:option value="none" label="------- Select One -------" />
                        <form:options items="${communeList}" />
                    </form:select>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <p style="margin-top: 12px; margin-bottom: 14px">
                        Địa chỉ nơi ở <span style="font-style: italic; color: red">(*)</span>
                    </p>
                    <form:input path="address" cssStyle="width: 100%; height: 40px; border-radius: 6px; margin-top: -9px"/>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6">
                    <p style="margin-top: 12px; margin-bottom: 14px">
                        Điện thoại <span style="font-style: italic; color: red">(*)</span>
                    </p>
                    <form:input path="phone" cssStyle="width: 100%; height: 40px; border-radius: 6px; margin-top: -9px"/>
                </div>
                <div class="col-lg-6">
                    <p style="margin-top: 12px; margin-bottom: 14px">
                        Email
                    </p>
                    <form:input path="email" cssStyle="width: 100%; height: 40px; border-radius: 6px; margin-top: -9px"/>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <p style="margin-top: 12px; margin-bottom: 14px">
                        Trong vòng 14 ngày qua, anh/chị có thấy xuất hiện dấu hiệu nào sau đây không? <span
                            style="font-style: italic; color: red">(*)</span>
                    </p>
                    <table>
                        <tr>
                            <th style="width: 40%">Triệu chứng</th>
                            <th style="width: 5%">Có</th>
                            <th style="width: 5%">Không</th>
                            <th style="width: 40%">Triệu chứng</th>
                            <th style="width: 5%">Có</th>
                            <th style="width: 5%">Không</th>
                        </tr>
                        <tr>
                            <td>Sốt <span style="font-style: italic; color: red">(*)</span></td>
                            <td><form:radiobutton path="symptom.sot" value="true"/></td>
                            <td><form:radiobutton path="symptom.sot" value="false"/></td>
                            <td>Nôn/Buồn nôn <span style="font-style: italic; color: red">(*)</span></td>
                            <td><form:radiobutton path="symptom.non" value="true"/></td>
                            <td><form:radiobutton path="symptom.non" value="false"/></td>
                        </tr>
                        <tr>
                            <td>Ho <span style="font-style: italic; color: red">(*)</span></td>
                            <td><form:radiobutton path="symptom.ho" value="true"/></td>
                            <td><form:radiobutton path="symptom.ho" value="false"/></td>
                            <td>Tiêu chảy <span style="font-style: italic; color: red">(*)</span></td>
                            <td><form:radiobutton path="symptom.tieuChay" value="true"/></td>
                            <td><form:radiobutton path="symptom.tieuChay" value="false"/></td>
                        </tr>
                        <tr>
                            <td>Khó thở <span style="font-style: italic; color: red">(*)</span></td>
                            <td><form:radiobutton path="symptom.khoTho" value="true"/></td>
                            <td><form:radiobutton path="symptom.khoTho" value="false"/></td>
                            <td>Xuất huyết ngoài da <span style="font-style: italic; color: red">(*)</span></td>
                            <td><form:radiobutton path="symptom.xuatHuyet" value="true"/></td>
                            <td><form:radiobutton path="symptom.xuatHuyet" value="false"/></td>
                        </tr>
                        <tr>
                            <td>Đau họng <span style="font-style: italic; color: red">(*)</span></td>
                            <td><form:radiobutton path="symptom.dauHong" value="true"/></td>
                            <td><form:radiobutton path="symptom.dauHong" value="false"/></td>
                            <td>Nổi ban ngoài da <span style="font-style: italic; color: red">(*)</span></td>
                            <td><form:radiobutton path="symptom.noiBan" value="true"/></td>
                            <td><form:radiobutton path="symptom.noiBan" value="false"/></td>
                        </tr>
                    </table>
                </div>
                <div class="row">
                    <div class="col-lg-12">
                        <p style="margin-top: 12px; margin-bottom: 14px">
                            Lịch Sử phơi nhiễm:Trong vòng 14 ngày qua, anh/chị có <span
                                style="font-style: italic; color: red">(*)</span>
                        </p>
                        <table>
                            <tr>
                                <th style="width: 80%"></th>
                                <th style="width: 10%">Có</th>
                                <th style="width: 10%">Không</th>
                            </tr>
                            <tr>
                                <td>Đến trang trại chăn nuôi/chợ buôn bán động vật sống/cơ sở giết mổ động vật/tiếp xúc động
                                    vật <span style="font-style: italic; color: red">(*)</span></td>
                                <td><form:radiobutton path="exposure.tiepXucDongVat" value="true"/></td>
                                <td><form:radiobutton path="exposure.tiepXucDongVat" value="false"/></td>
                            </tr>
                            <tr>
                                <td>Tiếp xúc gần(<2m) với người mắc bệnh viêm đường hô hấp do nCoV <span
                                        style="font-style: italic; color: red">(*)</span></td>
                                <td><form:radiobutton path="exposure.tiepXucBenhNhan" value="true"/></td>
                                <td><form:radiobutton path="exposure.tiepXucBenhNhan" value="false"/></td>
                            </tr>
                        </table>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-12">
                        <p style="font-weight: bold; font-size: 14px; color: red; margin-top: 30px; margin-bottom: 6px">
                            Dữ liệu bạn cung cấp hoàn toàn bảo mật và chỉ phục vụ cho viêc phòng chống dịch, thuộc quản lý
                            của Ban chỉ đạo quốc gia về
                            phòng chống Covid-19.
                        </p>
                        <p style="font-weight: bold; font-size: 14px; color: red">
                            Khi bạn nhấn nút "Gửi" là bạn đã hiểu và đồng ý .
                        </p>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <form:button>GỬI TỜ KHAI</form:button>
                </div>
            </div>
        </form:form>
    </div>
</div>
</div>

</body>
</html>
