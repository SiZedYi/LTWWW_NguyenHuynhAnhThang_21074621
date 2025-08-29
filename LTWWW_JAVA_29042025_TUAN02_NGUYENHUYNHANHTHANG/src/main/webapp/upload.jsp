<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Upload multi-files</title>
    <style>
        body { font-family: Arial, sans-serif; }
        .upload-box {
            margin: 40px auto;
            width: 350px;
            border: 1px solid #ccc;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 2px 2px 8px #aaa;
            background: #f9f9f9;
        }
        h1 { text-align: center; font-size: 2em; margin-bottom: 20px; }
        .file-row { margin-bottom: 10px; }
        label { display: inline-block; width: 70px; }
        input[type="file"] { width: 180px; }
        .btn-row { text-align: center; margin-top: 20px; }
        input[type="submit"], input[type="reset"] {
            padding: 6px 18px;
            margin: 0 10px;
            font-size: 1em;
        }
    </style>
</head>
<body>
    <div class="upload-box">
        <h1>Upload multi-files</h1>
        <form action="upload" method="post" enctype="multipart/form-data">
            <div class="file-row">
                <label>File #1:</label>
                <input type="file" name="file1" />
            </div>
            <div class="file-row">
                <label>File #2:</label>
                <input type="file" name="file2" />
            </div>
            <div class="file-row">
                <label>File #3:</label>
                <input type="file" name="file3" />
            </div>
            <div class="file-row">
                <label>File #4:</label>
                <input type="file" name="file4" />
            </div>
            <div class="file-row">
                <label>File #5:</label>
                <input type="file" name="file5" />
            </div>
            <div class="btn-row">
                <input type="submit" value="Upload" />
                <input type="reset" value="Reset" />
            </div>
        </form>
    </div>
</body>
</html>

