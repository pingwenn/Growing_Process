# 📘 Growth Process 專案 Git 操作說明文件

## 📂 專案初始化與設定

1. **Clone 專案：**
   ```bash
   git clone https://github.com/pingwenn/Growing_Process.git
   cd Growing_Process
   ```

2. **檢查遠端連結：**
   ```bash
   git remote -v
   ```

---

## 🧑‍💻 分支管理

### 🔄 建立新功能分支（Feature Branch）
```bash
git checkout -b feature/功能名稱
```

### ☁️ 推送新分支到 GitHub
```bash
git push -u origin feature/功能名稱
```

### 🔁 合併分支（在 main 中操作）
```bash
git checkout main
git pull origin main
git merge feature/功能名稱
git push origin main
```

---

## 📤 提交與推送流程

1. **檢查狀態：**
   ```bash
   git status
   ```

2. **加入檔案變更：**
   ```bash
   git add .
   ```

3. **提交描述：**
   ```bash
   git commit -m "描述這次修改做了什麼"
   ```

4. **推送到遠端：**
   ```bash
   git push origin 分支名稱
   ```

---

## 🔒 敏感檔案管理

- 專案已加入 `.gitignore` 忽略設定：
  ```
  src/main/resources/application.properties
  ```

- 若本地誤加入敏感檔案，使用：
  ```bash
  git rm --cached src/main/resources/application.properties
  echo "src/main/resources/application.properties" >> .gitignore
  git commit -m "Remove sensitive config from repo"
  git push origin main
  ```

---

## 🔀 分支命名建議（業界常見）

| 類型 | 範例 | 用途說明 |
|------|------|----------|
| 功能開發 | `feature/user-login` | 新功能、畫面、API |
| 修復 Bug | `fix/login-error` | 錯誤修正 |
| 重構 | `refactor/service-layer` | 程式優化，不影響功能 |
| 文件 | `docs/update-readme` | 變更說明文件或註解 |
| 發行版本 | `release/v1.0.0` | 準備發佈的穩定版 |
