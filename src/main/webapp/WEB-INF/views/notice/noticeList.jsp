<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>NoticeList</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <style>
        @import url(https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.4.3/css/mdb.min.css);

        .darken-grey-text {
            color: #2E2E2E;
        }

        .input-group.md-form.form-sm.form-2 input {
            border: 1px solid #bdbdbd;
            border-top-left-radius: 0.25rem;
            border-bottom-left-radius: 0.25rem;
        }

        .input-group.md-form.form-sm.form-2 input.purple-border {
            border: 1px solid #9e9e9e;
        }
    </style>
</head>

<body class="hm-gradient">
    <main>
        <div class="container mt-4">
            <div class="card mb-4"></div>
            <div class="card">
                <div class="card-body">
                    <div class="row">
                        <div class="col-md-12">
                            <h1 class="py-3 text-center font-bold font-up" style="color: #02876C">공지사항</h1>
                        </div>

                    </div>

                    <table class="table table-hover table-responsive mb-0">

                        <thead>
                            <tr>
                                <th scope="row">#</th>
                                <th class="th-lg"><a>작성자</a></th>
                                <th class="th-lg"><a href="">제목</a></th>
                                <th class="th-lg"><a href=""></a></th>
                                <th class="th-lg"><a href=""></a></th>
                                <th class="th-lg"><a href=""></a></th>
                                <th class="th-lg"><a href=""></a></th>
                            </tr>
                        </thead>
                        <tr>
                            <th scope="row">1</th>
                            <td>관리자</td>
                            <td>내용</td>
                            <td></td>
                            <td></td>
                            <td></td>

                        </tr>
                        <tr>
                            <th scope="row">2</th>
                            <td>관리자</td>
                            <td>내용</td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <th scope="row">3</th>
                            <td>관리자</td>
                            <td>내용</td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <th scope="row">4</th>
                            <td>관리자</td>
                            <td>내용</td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <th scope="row">5</th>
                            <td>관리자</td>
                            <td>내용</td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>

                    </table>
                    <div class="d-flex justify-content-center">
                        <nav class="my-4 pt-2">
                            <ul class="pagination pagination-circle pg-blue mb-0">
                                <li class="page-item disabled clearfix d-none d-md-block"><a class="page-link">First</a>
                                </li>
                                <li class="page-item disabled">
                                    <a class="page-link" aria-label="Previous">
                                        <span aria-hidden="true">«</span>
                                        <span class="sr-only">Previous</span>
                                    </a>
                                </li>
                                <li class="page-item active"><a class="page-link">1</a></li>
                                <li class="page-item"><a class="page-link">2</a></li>
                                <li class="page-item"><a class="page-link">3</a></li>
                                <li class="page-item"><a class="page-link">4</a></li>
                                <li class="page-item"><a class="page-link">5</a></li>
                                <li class="page-item">

                                    <a class="page-link" aria-label="Next">
                                        <span aria-hidden="true">»</span>
                                        <span class="sr-only">Next</span>
                                    </a>
                                </li>
                                <li class="page-item clearfix d-none d-md-block"><a class="page-link">Last</a></li>
                            </ul>
                        </nav>
                    </div>
                    <div>
                        <button type="button" class="btn btn-dark noticegul"
                            style="background-color: #02876C;">글쓰기</button>
                    </div>
    </main>
</body>

</html>